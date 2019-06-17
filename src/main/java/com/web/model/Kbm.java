package com.web.model;

public class Kbm {
    private Integer id;

    private String technicalName;

    private String parts;

    private String kbmDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTechnicalName() {
        return technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName == null ? null : technicalName.trim();
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts == null ? null : parts.trim();
    }

    public String getKbmDesc() {
        return kbmDesc;
    }

    public void setKbmDesc(String kbmDesc) {
        this.kbmDesc = kbmDesc == null ? null : kbmDesc.trim();
    }
}