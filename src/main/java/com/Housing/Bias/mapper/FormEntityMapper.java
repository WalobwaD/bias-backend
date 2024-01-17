package com.Housing.Bias.mapper;

import com.Housing.Bias.entity.FormEntity;
import com.Housing.Bias.model.form.request.Form;

import java.math.BigDecimal;

public class FormEntityMapper {

    public static FormEntity createFormEntity(Form form) {
        FormEntity formEntity = new FormEntity();
        formEntity.setAddress(form.getAddress());
        formEntity.setZipCode(form.getZipCode());
        formEntity.setCountry(form.getCountry());
        formEntity.setState(form.getState());
        formEntity.setDistanceFromSubject(form.getDistanceFromSubject());
        formEntity.setSale(form.getSale());
        formEntity.setSalePrice(form.getSalePrice());
        formEntity.setYearBuild(form.getYearBuild());
        formEntity.setStyle(form.getStyle());
        formEntity.setBathsFull(form.getBathsFull());
        formEntity.setBathsHalf(form.getBathsHalf());
        formEntity.setGarageDet(form.getGarageDet());
        formEntity.setGarageAtt(form.getGarageAtt());
        formEntity.setBasement(form.getBasement());
        formEntity.setUnfinishedFull(form.getUnfinishedFull());
        formEntity.setUnfinishedPartial(form.getUnfinishedPartial());
        formEntity.setFinishedFull(form.getFinishedFull());
        formEntity.setFinishedPartial(form.getFinishedPartial());
        formEntity.setCondition(form.getCondition());
        formEntity.setConstruction(form.getConstruction());
        formEntity.setQtyConstruction(form.getQtyConstruction());
        formEntity.setLotSize(form.getLotSize());
        formEntity.setUtilities(form.getUtilities());
        formEntity.setPool(form.isPool());
        formEntity.setCorner(form.getCorner());
        formEntity.setOtherFeatures(form.getOtherFeatures());
        formEntity.setOther(form.getOther());
        formEntity.setType(form.getType());
        formEntity.setValue(form.getValue());
        formEntity.setRoom(form.getRoom());

        return formEntity;
    }
}
