package com.example.service;

import com.example.model.OperationModel;
import org.springframework.stereotype.Service;

@Service
public class CalculateSimple {

    public int add(OperationModel model) {
        return Integer.parseInt(model.getA()) + Integer.parseInt(model.getB());
    }

    public int subtract(OperationModel model) {
        return Integer.parseInt(model.getA()) - Integer.parseInt(model.getB());
    }

    public int multiply(OperationModel model) {
        return Integer.parseInt(model.getA()) * Integer.parseInt(model.getB());
    }

    public double divide(OperationModel model) {
        if (Integer.parseInt(model.getA()) == 0) return 0;
        if (Integer.parseInt(model.getB()) == 0) return 0;
        return Double.parseDouble(model.getA()) / Double.parseDouble(model.getB());
    }

    public OperationModel clearSimple(OperationModel model) {
        model.setA("");
        model.setB("");
        model.setOperator("");
        return model;
    }
}
