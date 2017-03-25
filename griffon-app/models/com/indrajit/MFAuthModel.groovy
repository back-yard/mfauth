package com.indrajit

import griffon.core.artifact.GriffonModel
import griffon.transform.Observable
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonModel)
class MFAuthModel {
    @Observable int clickCount = 0
}