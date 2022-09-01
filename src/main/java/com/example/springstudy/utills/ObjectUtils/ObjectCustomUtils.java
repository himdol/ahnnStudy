package com.example.springstudy.utills.ObjectUtils;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class ObjectCustomUtils extends ObjectUtils {

    /**
     Params: obj – the object to check
     Returns: true if the object is not null or not empty
     create by: himdol
     */
    public static boolean isNotEmpty(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Optional) {
            return !((Optional<?>) obj).isPresent();
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).isEmpty();
        }

        // else
        return true;
    }

}
