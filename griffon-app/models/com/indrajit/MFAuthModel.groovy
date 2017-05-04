package com.indrajit

import griffon.core.artifact.GriffonModel
import griffon.transform.Observable
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonModel)
class MFAuthModel {
    @Observable ObservableMap authToken = new ObservableMap(new HashMap<String, Integer>())
    @Observable Boolean changed = false
}