/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.modules;

import java.util.Set;
import org.jboss.modules.filter.ClassFilter;
import org.jboss.modules.filter.PathFilter;

/**
* @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
*/
final class ModuleClassLoaderDependency extends Dependency {
    private final ModuleClassLoader moduleClassLoader;

    ModuleClassLoaderDependency(final PathFilter exportFilter, final PathFilter importFilter, final PathFilter resourceExportFilter, final PathFilter resourceImportFilter, final ClassFilter classExportFilter, final ClassFilter classImportFilter, final ModuleClassLoader moduleClassLoader) {
        super(exportFilter, importFilter, resourceExportFilter, resourceImportFilter, classExportFilter, classImportFilter);
        this.moduleClassLoader = moduleClassLoader;
    }

    LocalLoader getLocalLoader() {
        return moduleClassLoader.getLocalLoader();
    }

    Set<String> getPaths() {
        return moduleClassLoader.getPaths();
    }

    public String toString() {
        return "dependency on " + moduleClassLoader;
    }
}
