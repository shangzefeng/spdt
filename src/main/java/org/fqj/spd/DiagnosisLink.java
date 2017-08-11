/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fqj.spd;

/**
 *
 * @author Fsz
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
     * all points consume time.
     */
    private long totalConsumeTime;

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
     * all points consume time.
     *
     * @return the totalConsumeTime
     */
    public long getTotalConsumeTime() {
        return totalConsumeTime;
    }

    /**
     * all points consume time.
     *
     * @param totalConsumeTime the totalConsumeTime to set
     */
    public void setTotalConsumeTime(long totalConsumeTime) {
        this.totalConsumeTime = totalConsumeTime;
    }

    /**
     * diagnosis root point.
     * @return the rootDiagnosisPoint
     */
    public DiagnosisPoint getRootDiagnosisPoint() {
        return rootDiagnosisPoint;
    }

    /**
     * diagnosis root point.
     * @param rootDiagnosisPoint the rootDiagnosisPoint to set
     */
    public void setRootDiagnosisPoint(DiagnosisPoint rootDiagnosisPoint) {
        this.rootDiagnosisPoint = rootDiagnosisPoint;
    }
}
