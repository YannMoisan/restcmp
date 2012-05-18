package com.yannmoisan.restcmp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FibServiceImpl implements FibService {
    /* (non-Javadoc)
     * @see com.yannmoisan.restcmp.service.FibService#calculate(int)
     */
    //@Override
    public List<Long> calculate(int limit) {
        List<Long> result = new ArrayList<Long>();
        result.add(1l);
        if (limit > 1) {
            result.add(1l);
            for (int i = 2; i < limit; i++) {
                result.add(result.get(i - 2) + (result.get(i - 1)));
            }
        }
        return result;
    }
}
