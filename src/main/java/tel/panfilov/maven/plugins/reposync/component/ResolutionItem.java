/*-
 * #%L
 * reposync-maven-plugin
 * %%
 * Copyright (C) 2022 Project Contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package tel.panfilov.maven.plugins.reposync.component;

import org.eclipse.aether.RequestTrace;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.impl.UpdateCheck;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.resolution.ArtifactRequest;
import org.eclipse.aether.resolution.ArtifactResult;
import org.eclipse.aether.spi.connector.ArtifactDownload;
import org.eclipse.aether.transfer.ArtifactTransferException;

import java.util.concurrent.atomic.AtomicBoolean;

public class ResolutionItem {

    final RequestTrace trace;

    final ArtifactRequest request;

    final ArtifactResult result;

    final RemoteRepository repository;

    final Artifact artifact;

    final AtomicBoolean resolved;

    ArtifactDownload download;

    UpdateCheck<Artifact, ArtifactTransferException> updateCheck;

    ResolutionItem(RequestTrace trace, Artifact artifact, AtomicBoolean resolved, ArtifactResult result, RemoteRepository repository) {
        this.trace = trace;
        this.artifact = artifact;
        this.resolved = resolved;
        this.result = result;
        this.request = result.getRequest();
        this.repository = repository;
    }

}
