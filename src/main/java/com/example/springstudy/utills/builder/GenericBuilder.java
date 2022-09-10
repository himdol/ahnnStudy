package com.example.springstudy.utills.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GenericBuilder <T>{

    private final Supplier<T> instantiator;

    /**
    * Supplier<T> 는 매개변수를 받지 않고 단순히 무엇인가를 반환하는 추상메서드가 존재합니다.
     *
    * */

    private List<Consumer<T>> instanceModifiers = new ArrayList<>();

    public GenericBuilder(Supplier instantiator) {
        this.instantiator = instantiator;
    }

    public static <T> GenericBuilder<T> of(Supplier<T> instantiator) {
        return new GenericBuilder<>(instantiator);
    }

    public <U> GenericBuilder<T> with(BiConsumer<T,U> consumer, U value) {
        Consumer<T> c = instance -> consumer.accept(instance, value);
        return this;
    }

    public T build(){
        T value = instantiator.get();
        instanceModifiers.forEach(modefier -> modefier.accept(value));
        instanceModifiers.clear();
        return value;
    }

}
