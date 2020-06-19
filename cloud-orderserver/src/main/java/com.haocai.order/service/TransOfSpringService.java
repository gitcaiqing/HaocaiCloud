package com.haocai.order.service;

public interface TransOfSpringService {
    void testPropagationRequired();

    void testPropagationSupports();

    void testPropagationMandatory();

    void testPropagationRequireNew();

    void testPropagationNotSupported();

    void testPropagationNever();

    void testPropagationNested();
}
