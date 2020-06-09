package fr.ensim.interop.eval.exo2.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FakeBDD {
    public static final Map<Integer, Plantation> fakeBDD = new HashMap<Integer, Plantation>();
    public static final AtomicInteger seq = new AtomicInteger();
}
