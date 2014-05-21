/**
 * Copyright (C) 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dashbuilder.dataset.function;

import java.util.Iterator;
import java.util.List;

/**
 * It calculates the sum value of a set of numbers.
 */
public class SumFunction extends AbstractFunction {

    /**
     * The code of the function.
     */
    public static final String CODE = "sum";

    public SumFunction() {
        super();
    }

    public String getCode() {
        return CODE;
    }

    public double scalar(List values) {
        if (values == null || values.isEmpty()) return 0;

        // Sum the collection.
        double sum = 0;
        Iterator it = values.iterator();
        while (it.hasNext()) {
            Number n = (Number) it.next();
            if (n == null) continue;
            sum += n.doubleValue();
        }
        double ret = round(sum, precission);
        return ret;
    }

    public double scalar(List values, List<Integer> rows) {
        if (rows == null) return scalar(values);
        if (rows.isEmpty()) return 0;
        if (values == null || values.isEmpty()) return 0;

        // Sum the collection.
        double sum = 0;
        for (Integer row : rows) {
            Number n = (Number) values.get(row);
            if (n == null) continue;
            sum += n.doubleValue();
        }
        double ret = round(sum, precission);
        return ret;
    }
}