// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.web.controller;

import com.cyu.laclad.domain.Idiom;
import com.cyu.laclad.web.controller.ApplicationConversionServiceFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<Idiom, String> ApplicationConversionServiceFactoryBean.getIdiomToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.cyu.laclad.domain.Idiom, java.lang.String>() {
            public String convert(Idiom idiom) {
                return new StringBuilder().append(idiom.getDescription()).toString();
            }
        };
    }
    
    public Converter<Long, Idiom> ApplicationConversionServiceFactoryBean.getIdToIdiomConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.cyu.laclad.domain.Idiom>() {
            public com.cyu.laclad.domain.Idiom convert(java.lang.Long id) {
                return Idiom.findIdiom(id);
            }
        };
    }
    
    public Converter<String, Idiom> ApplicationConversionServiceFactoryBean.getStringToIdiomConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.cyu.laclad.domain.Idiom>() {
            public com.cyu.laclad.domain.Idiom convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Idiom.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getIdiomToStringConverter());
        registry.addConverter(getIdToIdiomConverter());
        registry.addConverter(getStringToIdiomConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
