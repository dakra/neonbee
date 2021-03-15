package io.neonbee.entity;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnnotationTargetTest {
    private static final String ANY_MODEL_SERVICE_PRODUCTS = "AnyModel.Service.Products";

    private static final String ANY_MODEL_SERVICE_PRODUCTS_ID = "AnyModel.Service.Products/id";

    private static final String ANY_MODEL_SERVICE_PRODUCTS_NAME = "AnyModel.Service.Products/name";

    private final AnnotationTarget name = new AnnotationTarget(ANY_MODEL_SERVICE_PRODUCTS_NAME);

    private final AnnotationTarget id = new AnnotationTarget(ANY_MODEL_SERVICE_PRODUCTS_ID);

    private final AnnotationTarget entity = new AnnotationTarget(ANY_MODEL_SERVICE_PRODUCTS);

    @Test
    @DisplayName("check equals and hashcode works")
    void hashCodeEqualsTest() {
        assertThat(name).isEqualTo(new AnnotationTarget(ANY_MODEL_SERVICE_PRODUCTS_NAME));
        assertThat(name).isNotEqualTo(id);
        assertThat(name).isNotEqualTo(entity);

        assertThat(name.hashCode()).isEqualTo(new AnnotationTarget(ANY_MODEL_SERVICE_PRODUCTS_NAME).hashCode());
        assertThat(name.hashCode()).isNotEqualTo(id.hashCode());
        assertThat(name.hashCode()).isNotEqualTo(entity.hashCode());
    }

    @Test
    @DisplayName("check if getters work")
    void gettersTest() {
        assertThat(name.getEntityName()).isEqualTo(ANY_MODEL_SERVICE_PRODUCTS);
        assertThat(name.getProperty().get()).isEqualTo("name");
        assertThat(entity.getEntityName()).isEqualTo(ANY_MODEL_SERVICE_PRODUCTS);
        assertThat(entity.getProperty().isEmpty()).isTrue();
    }

    @Test
    @DisplayName("check if toString works")
    void toStringTest() {
        assertThat(name.toString())
                .isEqualTo("AnnotationProperty [entityName=AnyModel.Service.Products, property=Optional[name]]");
    }
}
