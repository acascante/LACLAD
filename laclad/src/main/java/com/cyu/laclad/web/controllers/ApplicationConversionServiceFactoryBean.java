package com.cyu.laclad.web.controllers;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

import com.cyu.laclad.domain.SystemUser;

@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	@SuppressWarnings("deprecation")
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		registry.addConverter(getLogUserRoleToStringConverter());
		registry.addConverter(createEnumConverter());
	}
		 
	public Converter<SystemUser, String> getLogUserRoleToStringConverter() {
		return new org.springframework.core.convert.converter.Converter<SystemUser, String>() {
			public String convert(SystemUser user) {
				return new StringBuilder().append(user.getUserName()).toString();
		    }
		};
	}
	
	private Converter<Enum<?>, String> createEnumConverter() {
        return new Converter<Enum<?>, String>() {
            @Override
            public String convert(Enum<?> value) {
                String output = value.toString();
                try {
                    output = applicationContext.getMessage(value.toString(), null, LocaleContextHolder.getLocale());
                } catch (NoSuchMessageException e) {
                    System.err.println("No message resource found for " + value + " add this to the resource bundle");
                }
                return output;
            }
        };
    }
	
	@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}