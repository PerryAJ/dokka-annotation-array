/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package com.github.perryaj;

import org.python.core.PyObject;

/**
 * Here is a doc.
 */
public class Library {
    /**
     * This causes a ClassCastException by Dokka
     */
    @SimpleAnnotation(clazz = String[].class)
    public boolean simpleAnnotation() {
        return false;
    }
}