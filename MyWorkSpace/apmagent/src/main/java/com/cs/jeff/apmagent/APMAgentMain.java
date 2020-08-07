package com.cs.jeff.apmagent;

import co.elastic.apm.attach.ElasticApmAttacher;

public class APMAgentMain {

    public static void main(final String []args) {
        ElasticApmAttacher.attach();
    }

}
