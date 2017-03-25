package com.indrajit

import griffon.core.artifact.GriffonController
import griffon.inject.MVCMember
import griffon.metadata.ArtifactProviderFor
import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonController)
class MFAuthController {
    @MVCMember @Nonnull
    MFAuthModel model

    void click() {
        model.clickCount++
    }
}