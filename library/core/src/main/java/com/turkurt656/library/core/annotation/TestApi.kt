package com.turkurt656.library.core.annotation

import kotlin.annotation.AnnotationTarget.*

/**
 * This annotation marks the design library API that is considered for test only.
 * the behavior of such API may be changed or the API may be removed completely in any further release.
 *
 * > Beware using the annotated API especially if you're developing a library, since your library might become binary incompatible
 * with the future versions of the standard library.
 *
 * Any usage of a declaration annotated with `@TestDesignApi` must be accepted either by
 * annotating that usage with the [OptIn] annotation, e.g. `@OptIn(TestDesignApi::class)`,
 * or by using the compiler argument `-Xopt-in=kotlin.TestDesignApi`.
 */
@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
@Retention(AnnotationRetention.BINARY)
@Target(
    CLASS,
    ANNOTATION_CLASS,
    PROPERTY,
    FIELD,
    LOCAL_VARIABLE,
    VALUE_PARAMETER,
    CONSTRUCTOR,
    FUNCTION,
    PROPERTY_GETTER,
    PROPERTY_SETTER,
    TYPEALIAS
)
annotation class TestApi