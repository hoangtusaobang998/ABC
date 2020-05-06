package com.teamdev.demngayyeu.lite.raw;

import com.teamdev.demngayyeu.lite.R;
import com.teamdev.demngayyeu.lite.utils.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilsRaw {

    private static List list = null;

    public static synchronized void initRaw() {
        list = Arrays.asList(
                UtilsRaw.rawID(R.raw.type_1),
                UtilsRaw.rawID(R.raw.type_2),
                UtilsRaw.rawID(R.raw.type_3),
                UtilsRaw.rawID(R.raw.type_4),
                UtilsRaw.rawID(R.raw.type_5),
                UtilsRaw.rawID(R.raw.type_6),
                UtilsRaw.rawID(R.raw.type_7),
                UtilsRaw.rawID(R.raw.type_8),
                UtilsRaw.rawID(R.raw.type_9),
                UtilsRaw.rawID(R.raw.type_10),
                UtilsRaw.rawID(R.raw.type_11),
                UtilsRaw.rawID(R.raw.type_12),
                UtilsRaw.rawID(R.raw.type_13),
                UtilsRaw.rawID(R.raw.type_14),
                UtilsRaw.rawID(R.raw.type_15),
                UtilsRaw.rawID(R.raw.type_16),
                UtilsRaw.rawID(R.raw.type_17),
                UtilsRaw.rawID(R.raw.type_18),
                UtilsRaw.rawID(R.raw.type_19),
                UtilsRaw.rawID(R.raw.type_20),
                UtilsRaw.rawID(R.raw.type_21),
                UtilsRaw.rawID(R.raw.type_22),
                UtilsRaw.rawID(R.raw.type_23),
                UtilsRaw.rawID(R.raw.type_24),
                UtilsRaw.rawID(R.raw.type_25),
                UtilsRaw.rawID(R.raw.type_26),
                UtilsRaw.rawID(R.raw.type_27),
                UtilsRaw.rawID(R.raw.type_28),
                UtilsRaw.rawID(R.raw.type_29),
                UtilsRaw.rawID(R.raw.type_30),
                UtilsRaw.rawID(R.raw.type_31),
                UtilsRaw.rawID(R.raw.type_32),
                UtilsRaw.rawID(R.raw.type_33)
        );
    }

    private static int rawID(int id) {
        return id;
    }

    private static List<Integer> coveterInt() {
        if (UtilsRaw.list == null) {
            return null;
        }
        List<Integer> integerList = new ArrayList<>();
        for (Object i : UtilsRaw.list) {
         