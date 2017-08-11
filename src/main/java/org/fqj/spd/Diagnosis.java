/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fqj.spd;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Fsz
 */
public class Diagnosis {
    
    final static ThreadLocal<DiagnosisLink> diag = new ThreadLocal<>();
    
    public static void start(final String pointName) {
        
        final DiagnosisPoint point = new DiagnosisPoint(pointName);
        
        DiagnosisLink diagnosisLink = diag.get();
        
        if (diagnosisLink == null) {
            diagnosisLink = new DiagnosisLink();
            diag.set(diagnosisLink);
            
            point.setRootPoint(true);
            point.setPrePoint(null);
            point.setLevel(0);
            
            diagnosisLink.setRootDiagnosisPoint(point);
            
        } else {
            point.setPrePoint(diagnosisLink.getCurrentPoint());
            point.setLevel(point.getPrePoint().getLevel() + 4);
            diagnosisLink.getCurrentPoint().addNextPoint(point);
        }
        diagnosisLink.setCurrentPoint(point);
    }
    
    public static void end() {
        final DiagnosisLink dlk = diag.get();
        if (dlk == null) {
            return;
        }
        final DiagnosisPoint dp = dlk.getCurrentPoint();
        if (dp == null) {
            return;
        }
        dp.setEndTime(System.currentTimeMillis());
        dp.setConsumeTime(dp.getEndTime() - dp.getStartTime());
        dlk.setCurrentPoint(dp.getPrePoint());
        dlk.setTotalConsumeTime(dlk.getTotalConsumeTime() + dp.getConsumeTime());
    }
    
    public static long getSpendTime() {
        final DiagnosisLink dlk = diag.get();
        if (dlk == null) {
            return 0;
        }
        return dlk.getTotalConsumeTime();
    }
    
    public static String getPonitConsume() {
        final StringBuilder sb = new StringBuilder();
        final DiagnosisLink dlk = diag.get();
        if (dlk == null) {
            return sb.toString();
        }
        final DiagnosisPoint rootPoint = dlk.getRootDiagnosisPoint();
        getSubPointConsumeContext(rootPoint, sb);
        return sb.toString();
    }
    
    public static void getSubPointConsumeContext(final DiagnosisPoint dp, final StringBuilder sb) {
        sb.append(StringUtils.repeat(" ", dp.getLevel())).append(dp.getPointName()).append(" [").append(dp.getConsumeTime()).append("]\n");
        final List<DiagnosisPoint> dps = dp.getNextPoint();
        for (Iterator<DiagnosisPoint> iterator = dps.iterator(); iterator.hasNext();) {
            DiagnosisPoint next = iterator.next();
            getSubPointConsumeContext(next, sb);
        }
    }
    
    public static void release() {
        diag.remove();
    }
}
