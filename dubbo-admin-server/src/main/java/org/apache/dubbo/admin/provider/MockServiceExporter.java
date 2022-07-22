/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.admin.provider;

import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.mock.api.MockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MockServiceExporter implements CommandLineRunner {

    @Value("${dubbo.mock-server.enable:true}")
    private boolean enable;

    @Autowired
    private MockServiceProvider mockServiceProvider;

    @Override
    public void run(String... args) throws Exception {
        if (enable) {
            ServiceConfig<MockService> serviceConfig = new ServiceConfig<>();
            serviceConfig.setInterface(MockService.class);
            serviceConfig.setRef(mockServiceProvider);
            serviceConfig.export();
        }
    }
}
