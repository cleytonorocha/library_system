package com.github.cleyto_orocha.library_system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SwaggerEnum {

    public static final String USER_TAG_NAME = "1 - Login";
    public static final String CLIENT_TAG_NAME = "2 - Client";
    public static final String PRODUCT_TAG_NAME = "3 - Product";
    public static final String ACQUISITION_TAG_NAME = "4 - Acquisition";

    public static final String USER_TAG_DESCRIPTION = "Come and login on API!";
    public static final String CLIENT_TAG_DESCRIPTION = "Client operations";
    public static final String PRODUCT_TAG_DESCRIPTION = "Operations related by products";
    public static final String ACQUISITION_TAG_DESCRIPTION = "Rest operations of product purchases by the client";

}
