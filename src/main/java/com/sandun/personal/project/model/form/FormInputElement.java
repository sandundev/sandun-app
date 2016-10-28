package com.sandun.personal.project.model.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FormInputElement implements Serializable{
 
    private String elementId; // html element identifier
    private String fieldValue; 
    private String crudIds; // if need for UI to disable field.
    private String defaultValue; // ex. if by default, default date is today date..
    private String validationRegex; // if there is UI level validation.
    private String labelText;
    private Boolean hidden;
    private String fieldType; // DDL , Radio , text field etc..
    private String mandatory;
 

    public String getElementId() {
        return elementId;
    }


    public void setElementId(String elementId) {
        this.elementId = elementId;
    }


    public String getFieldValue() {
        return fieldValue;
    }


    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }


    public String getCrudIds() {
        return crudIds;
    }


    public void setCrudIds(String crudIds) {
        this.crudIds = crudIds;
    }


    public String getDefaultValue() {
        return defaultValue;
    }


    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }


    public String getValidationRegex() {
        return validationRegex;
    }


    public void setValidationRegex(String validationRegex) {
        this.validationRegex = validationRegex;
    }


    public String getLabelText() {
        return labelText;
    }


    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }


    public Boolean getHidden() {
        return hidden;
    }


    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }


    public String getFieldType() {
        return fieldType;
    }


    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }


    public String getMandatory() {
        return mandatory;
    }


    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }
}
