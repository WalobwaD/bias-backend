package com.Housing.Bias.service;

import com.Housing.Bias.entity.FormEntity;
import com.Housing.Bias.mapper.FormEntityMapper;
import com.Housing.Bias.model.form.request.Form;
import com.Housing.Bias.repository.FormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FormService {

    private final FormRepository formRepository;

    public FormEntity save(Form formRequest) {
        return formRepository.save(FormEntityMapper.createFormEntity(formRequest));
    }

    public List<FormEntity> getAll() {
        return formRepository.findAll();
    }

    public FormEntity getById(long id) {
        return formRepository.findById(id).orElse(new FormEntity());
    }

    public Boolean delete(long id) {
        FormEntity formEntity = new FormEntity();
        formEntity.setFormId(id);
        formRepository.delete(formEntity);
        return true;
    }
}
