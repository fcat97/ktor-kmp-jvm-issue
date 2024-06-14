package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.ProjectDependency;
import org.gradle.api.internal.artifacts.dependencies.ProjectDependencyInternal;
import org.gradle.api.internal.artifacts.DefaultProjectDependencyFactory;
import org.gradle.api.internal.artifacts.dsl.dependencies.ProjectFinder;
import org.gradle.api.internal.catalog.DelegatingProjectDependency;
import org.gradle.api.internal.catalog.TypeSafeProjectDependencyFactory;
import javax.inject.Inject;

@NonNullApi
public class LocalRecallProjectDependency extends DelegatingProjectDependency {

    @Inject
    public LocalRecallProjectDependency(TypeSafeProjectDependencyFactory factory, ProjectDependencyInternal delegate) {
        super(factory, delegate);
    }

    /**
     * Creates a project dependency on the project at path ":server"
     */
    public ServerProjectDependency getServer() { return new ServerProjectDependency(getFactory(), create(":server")); }

    /**
     * Creates a project dependency on the project at path ":serverJvm"
     */
    public ServerJvmProjectDependency getServerJvm() { return new ServerJvmProjectDependency(getFactory(), create(":serverJvm")); }

}
