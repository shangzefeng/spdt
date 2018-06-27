/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fqj.spd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 * service Diagnosis watcher.
 *
 * @author Fsz
 * @version 1.0.0.0, Aug 14, 2017
 * @since 1.0.0
 */
public class Diagnosis {

    /**
     * diagnosis point data.
     */
    final static ThreadLocal<DiagnosisLink> DIAGNOSIS_ENTRY = new ThreadLocal<>();

    /**
     * one thread max diagnosis point cnt.
     */
    final static int MAX_DIAGNOSIS_POINT_CNT = 100;

    /**
     * start diagnosis point.
     *
     * @param pointName ponit name.
     */
    public static void start(final String pointName) {

        final DiagnosisPoint point = new DiagnosisPoint(pointName);

        DiagnosisLink diagnosisLink = DIAGNOSIS_ENTRY.get();

        if (diagnosisLink == null) {
            diagnosisLink = new DiagnosisLink();
            DIAGNOSIS_ENTRY.set(diagnosisLink);

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

    /**
     * diagnosis point end.
     */
    public static void end() {
        final DiagnosisLink dlk = DIAGNOSIS_ENTRY.get();
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

        //set pre point consume time
        DiagnosisPoint point = dp;
        int i = 0;
        while (null != point || i > MAX_DIAGNOSIS_POINT_CNT) {
            i++;
            DiagnosisPoint prePoint = point.getPrePoint();
            if (null == prePoint) {
                break;
            }
            prePoint.setConsumeTime(prePoint.getConsumeTime() + point.getConsumeTime());
            point = prePoint;
        }
    }

    /**
     * get service total cost time.
     *
     * @return
     */
    public static long getTotalCostTime() {
        final DiagnosisLink dlk = DIAGNOSIS_ENTRY.get();
        if (dlk == null) {
            return 0;
        }
        return dlk.getRootDiagnosisPoint().getConsumeTime();
    }

    /**
     * get every point cost time msg.
     *
     * @return
     */
    public static String getCostMsg() {
        final StringBuilder sb = new StringBuilder();
        final DiagnosisLink dlk = DIAGNOSIS_ENTRY.get();
        if (dlk == null) {
            return sb.toString();
        }
        final DiagnosisPoint rootPoint = dlk.getRootDiagnosisPoint();
        final BigDecimal costTime = new BigDecimal(rootPoint.getConsumeTime());
        getSubPointConsumeContext(rootPoint, sb, costTime);
        return sb.toString();
    }

    /**
     * combin msg.
     *
     * @param dp diagnosis point.
     * @param sb msg.
     * @param costTime cost time.
     */
    public static void getSubPointConsumeContext(final DiagnosisPoint dp, final StringBuilder sb, final BigDecimal costTime) {

        BigDecimal range = BigDecimal.ZERO;
        BigDecimal pointCostTime = new BigDecimal(dp.getConsumeTime());

        if (pointCostTime.compareTo(BigDecimal.ZERO) == 1) {
            range = pointCostTime.divide(costTime, 2, RoundingMode.HALF_DOWN).multiply(new BigDecimal(100));
        }

        sb.append(StringUtils.repeat(" ", dp.getLevel())).append(dp.getPointName()).append(" [").
                append(dp.getConsumeTime()).append("ms    ").append(range).append("%  ]\n");
        final List<DiagnosisPoint> dps = dp.getNextPoint();
        for (Iterator<DiagnosisPoint> iterator = dps.iterator(); iterator.hasNext();) {
            DiagnosisPoint next = iterator.next();
            getSubPointConsumeContext(next, sb, costTime);
        }
    }

    /**
     * release .
     */
    public static void release() {
        DIAGNOSIS_ENTRY.remove();
    }
}
