package com.example.Objetos;

import java.time.LocalDateTime;

import com.example.Exepciones.ExceptionUser;

public class Dealership {
    private String distrinetCode;
    private String orCode;
    private String name;
    private String description;
    private String deliveryGoogleCalendarId;
    private String alias;
    private String fullAddress;
    private String location;
    private String phone;
    private String gmapsUrl;
    private String schedule1;
    private String schedule2;
    private String mechanicsPhone;
    private String mechanicsSchedule1;
    private String mechanicsSchedule2;
    private String bodyworkPhone;
    private String bodyworkSchedule1;
    private String bodyworkSchedule2;
    private String renaultMinute;
    private String extra;
    private Boolean isShownEmilsInfo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Dealership(String distrinetCode, String name, String deliveryGoogleCalendarId)
            throws ExceptionUser {
        if (distrinetCode.trim().isEmpty() || name.trim().isEmpty() || deliveryGoogleCalendarId.trim().isEmpty()) {
            throw new ExceptionUser("ERROR: datos ingresados incorrectos");
        }
        this.distrinetCode = distrinetCode;
        this.name = name;
        this.deliveryGoogleCalendarId = deliveryGoogleCalendarId;
    }

    public Dealership(String distrinetCode, String orCode, String name, String description,
            String deliveryGoogleCalendarId, String alias, String fullAddress, String location, String phone,
            String gmapsUrl, String schedule1, String schedule2, String mechanicsPhone, String mechanicsSchedule1,
            String mechanicsSchedule2, String bodyworkPhone, String bodyworkSchedule1, String bodyworkSchedule2,
            String renaultMinute, String extra, Boolean isShownEmilsInfo, LocalDateTime createdAt,
            LocalDateTime updatedAt) throws ExceptionUser {
        if (distrinetCode.trim().isEmpty() || name.trim().isEmpty() || deliveryGoogleCalendarId.trim().isEmpty()) {
            throw new ExceptionUser("ERROR: datos ingresados incorrectos");
        }
        this.distrinetCode = distrinetCode;
        this.orCode = orCode;
        this.name = name;
        this.description = description;
        this.deliveryGoogleCalendarId = deliveryGoogleCalendarId;
        this.alias = alias;
        this.fullAddress = fullAddress;
        this.location = location;
        this.phone = phone;
        this.gmapsUrl = gmapsUrl;
        this.schedule1 = schedule1;
        this.schedule2 = schedule2;
        this.mechanicsPhone = mechanicsPhone;
        this.mechanicsSchedule1 = mechanicsSchedule1;
        this.mechanicsSchedule2 = mechanicsSchedule2;
        this.bodyworkPhone = bodyworkPhone;
        this.bodyworkSchedule1 = bodyworkSchedule1;
        this.bodyworkSchedule2 = bodyworkSchedule2;
        this.renaultMinute = renaultMinute;
        this.extra = extra;
        this.isShownEmilsInfo = isShownEmilsInfo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void setDistrinetCode(String distrinetCode) {
        this.distrinetCode = distrinetCode;
    }

    public void setOrCode(String orCode) {
        this.orCode = orCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeliveryGoogleCalendarId(String deliveryGoogleCalendarId) {
        this.deliveryGoogleCalendarId = deliveryGoogleCalendarId;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGmapsUrl(String gmapsUrl) {
        this.gmapsUrl = gmapsUrl;
    }

    public void setSchedule1(String schedule1) {
        this.schedule1 = schedule1;
    }

    public void setSchedule2(String schedule2) {
        this.schedule2 = schedule2;
    }

    public void setMechanicsPhone(String mechanicsPhone) {
        this.mechanicsPhone = mechanicsPhone;
    }

    public void setMechanicsSchedule1(String mechanicsSchedule1) {
        this.mechanicsSchedule1 = mechanicsSchedule1;
    }

    public void setMechanicsSchedule2(String mechanicsSchedule2) {
        this.mechanicsSchedule2 = mechanicsSchedule2;
    }

    public void setBodyworkPhone(String bodyworkPhone) {
        this.bodyworkPhone = bodyworkPhone;
    }

    public void setBodyworkSchedule1(String bodyworkSchedule1) {
        this.bodyworkSchedule1 = bodyworkSchedule1;
    }

    public void setBodyworkSchedule2(String bodyworkSchedule2) {
        this.bodyworkSchedule2 = bodyworkSchedule2;
    }

    public void setRenaultMinute(String renaultMinute) {
        this.renaultMinute = renaultMinute;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setIsShownEmilsInfo(Boolean isShownEmilsInfo) {
        this.isShownEmilsInfo = isShownEmilsInfo;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDistrinetCode() {
        return distrinetCode;
    }

    public String getOrCode() {
        return orCode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDeliveryGoogleCalendarId() {
        return deliveryGoogleCalendarId;
    }

    public String getAlias() {
        return alias;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getGmapsUrl() {
        return gmapsUrl;
    }

    public String getSchedule1() {
        return schedule1;
    }

    public String getSchedule2() {
        return schedule2;
    }

    public String getMechanicsPhone() {
        return mechanicsPhone;
    }

    public String getMechanicsSchedule1() {
        return mechanicsSchedule1;
    }

    public String getMechanicsSchedule2() {
        return mechanicsSchedule2;
    }

    public String getBodyworkPhone() {
        return bodyworkPhone;
    }

    public String getBodyworkSchedule1() {
        return bodyworkSchedule1;
    }

    public String getBodyworkSchedule2() {
        return bodyworkSchedule2;
    }

    public String getRenaultMinute() {
        return renaultMinute;
    }

    public String getExtra() {
        return extra;
    }

    public Boolean getIsShownEmilsInfo() {
        return isShownEmilsInfo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((distrinetCode == null) ? 0 : distrinetCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dealership other = (Dealership) obj;
        if (distrinetCode == null) {
            if (other.distrinetCode != null)
                return false;
        } else if (!distrinetCode.equals(other.distrinetCode))
            return false;
        return true;
    }

    @Override
public String toString() {
    return "dealerships \n" +
            "distrinetCode: " + distrinetCode + "\n" +
            "orCode: " + (orCode != null && !orCode.trim().isEmpty() ? orCode : "No posee código OR") + "\n" +
            "name: " + name + "\n" +
            "description: " + (description != null && !description.trim().isEmpty() ? description : "No posee descripción") + "\n" +
            "deliveryGoogleCalendarId: " + deliveryGoogleCalendarId + "\n" +
            "alias: " + (alias != null && !alias.trim().isEmpty() ? alias : "No posee alias") + "\n" +
            "fullAddress: " + (fullAddress != null && !fullAddress.trim().isEmpty() ? fullAddress : "No posee dirección completa") + "\n" +
            "location: " + (location != null && !location.trim().isEmpty() ? location : "No posee ubicación") + "\n" +
            "phone: " + (phone != null && !phone.trim().isEmpty() ? phone : "No posee teléfono") + "\n" +
            "gmapsUrl: " + (gmapsUrl != null && !gmapsUrl.trim().isEmpty() ? gmapsUrl : "No posee URL de Google Maps") + "\n" +
            "schedule1: " + (schedule1 != null && !schedule1.trim().isEmpty() ? schedule1 : "No posee horario 1") + "\n" +
            "schedule2: " + (schedule2 != null && !schedule2.trim().isEmpty() ? schedule2 : "No posee horario 2") + "\n" +
            "mechanicsPhone: " + (mechanicsPhone != null && !mechanicsPhone.trim().isEmpty() ? mechanicsPhone : "No posee teléfono de mecánica") + "\n" +
            "mechanicsSchedule1: " + (mechanicsSchedule1 != null && !mechanicsSchedule1.trim().isEmpty() ? mechanicsSchedule1 : "No posee horario de mecánica 1") + "\n" +
            "mechanicsSchedule2: " + (mechanicsSchedule2 != null && !mechanicsSchedule2.trim().isEmpty() ? mechanicsSchedule2 : "No posee horario de mecánica 2") + "\n" +
            "bodyworkPhone: " + (bodyworkPhone != null && !bodyworkPhone.trim().isEmpty() ? bodyworkPhone : "No posee teléfono de carrocería") + "\n" +
            "bodyworkSchedule1: " + (bodyworkSchedule1 != null && !bodyworkSchedule1.trim().isEmpty() ? bodyworkSchedule1 : "No posee horario de carrocería 1") + "\n" +
            "bodyworkSchedule2: " + (bodyworkSchedule2 != null && !bodyworkSchedule2.trim().isEmpty() ? bodyworkSchedule2 : "No posee horario de carrocería 2") + "\n" +
            "renaultMinute: " + (renaultMinute != null && !renaultMinute.trim().isEmpty() ? renaultMinute : "No posee Renault Minute") + "\n" +
            "extra: " + (extra != null && !extra.trim().isEmpty() ? extra : "No posee información extra") + "\n" +
            "isShownEmilsInfo: " + (isShownEmilsInfo != null ? isShownEmilsInfo : "No posee información de Emils") + "\n" +
            "createdAt: " + (createdAt != null ? createdAt : "No posee fecha de creación") + "\n" +
            "updatedAt: " + (updatedAt != null ? updatedAt : "No posee fecha de actualización") + "\n";
}

    public String toSimpleString() {
        return "Código: " + distrinetCode +
                " Nombre: " + name +
                " Calendar ID: " + deliveryGoogleCalendarId;
    }
}