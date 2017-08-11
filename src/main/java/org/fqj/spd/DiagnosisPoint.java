/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fqj.spd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fsz
 */
public class DiagnosisPoint {

    /**
     * Diagnosis Point name.
     */
    private String pointName;

    /**
     * Diagnosis start time .
     */
    private Long startTime;

    /**
     * Diagnosis end time.
     */
    private Long endTime;

    /**
     * point consume time.
     */
    private Long consumeTime;

    /**
     * root point flag.
     * <p>
     * true : yes root point. false : no root point.
     * </p>
     */
    private boolean rootPoint = false;

    /**
     * new point.
     */
    private DiagnosisPoint prePoint;
    
    /**
     * diagnosis level.
     */
    private int level;

    /**
     * next point.
     */
    private List<DiagnosisPoint> nextPoint;

    public DiagnosisPoint(final String pointName) {
        this.pointName = pointName;
        this.startTime = System.currentTimeMillis();
        this.nextPoint = new ArrayList<>();
    }

    /**
     * Diagnosis Point name.
     *
     * @return the pointName
     */
    public String getPointName() {
        return pointName;
    }

    /**
     * Diagnosis Point name.
     *
     * @param pointName the pointName to set
     */
    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    /**
     * Diagnosis start time .
     *
     * @return the startTime
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * Diagnosis start time .
     *
     * @param startTime the startTime to set
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * Diagnosis end time.
     *
     * @return the endTime
     */
    public Long getEndTime() {
        return endTime;
    }

    /**
     * Diagnosis end time.
     *
     * @param endTime the endTime to set
     */
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    /**
     * new point.
     *
     * @return the prePoint
     */
    public DiagnosisPoint getPrePoint() {
        return prePoint;
    }

    /**
     * new point.
     *
     * @param prePoint the prePoint to set
     */
    public void setPrePoint(DiagnosisPoint prePoint) {
        this.prePoint = prePoint;
    }

    /**
     * root point flag.
     * <p>
     * true : yes root point. false : no root point.
     * </p>
     *
     * @return the rootPoint
     */
    public boolean isRootPoint() {
        return rootPoint;
    }

    /**
     * root point flag.
     * <p>
     * true : yes root point. false : no root point.
     * </p>
     *
     * @param rootPoint the rootPoint to set
     */
    public void setRootPoint(boolean rootPoint) {
        this.rootPoint = rootPoint;
    }

    /**
     * next point.
     *
     * @return the nextPoint
     */
    public List<DiagnosisPoint> getNextPoint() {
        return nextPoint;
    }

    /**
     * next point.
     *
     * @param nextPoint the nextPoint to set
     */
    public void addNextPoint(final DiagnosisPoint nextPoint) {
        this.nextPoint.add(nextPoint);
    }

    /**
     * point consume time.
     *
     * @return the consumeTime
     */
    public Long getConsumeTime() {
        return consumeTime;
    }

    /**
     * point consume time.
     *
     * @param consumeTime the consumeTime to set
     */
    public void setConsumeTime(Long consumeTime) {
        this.consumeTime = consumeTime;
    }

    /**
     * diagnosis level.
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * diagnosis level.
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

}
