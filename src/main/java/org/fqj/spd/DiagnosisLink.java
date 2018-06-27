/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fqj.spd;

/**
 * Diagnosis struct.
 *
 * @author Fsz
 * @version 1.0.0.0, Aug 14, 2017
 * @since 1.0.0
 */
public class DiagnosisLink {

    /**
     * diagnosis root point.
     */
    private DiagnosisPoint rootDiagnosisPoint;

    /**
     * diagnosis current point.
     */
    private DiagnosisPoint currentPoint;

    /**
     * diagnosis current point.
     *
     * @return the currentPoint
     */
    public DiagnosisPoint getCurrentPoint() {
        return currentPoint;
    }

    /**
     * diagnosis current point.
     *
     * @param currentPoint the currentPoint to set
     */
    public void setCurrentPoint(DiagnosisPoint currentPoint) {
        this.currentPoint = currentPoint;
    }

    /**
     * diagnosis root point.
     *
     * @return the rootDiagnosisPoint
     */
    public DiagnosisPoint getRootDiagnosisPoint() {
        return rootDiagnosisPoint;
    }

    /**
     * diagnosis root point.
     *
     * @param rootDiagnosisPoint the rootDiagnosisPoint to set
     */
    public void setRootDiagnosisPoint(DiagnosisPoint rootDiagnosisPoint) {
        this.rootDiagnosisPoint = rootDiagnosisPoint;
    }
}
