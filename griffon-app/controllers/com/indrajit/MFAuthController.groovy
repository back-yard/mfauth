package com.indrajit

import com.warrenstrange.googleauth.GoogleAuthenticator
import griffon.core.artifact.GriffonController
import griffon.inject.MVCMember
import griffon.metadata.ArtifactProviderFor
import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonController)
class MFAuthController {
    @MVCMember @Nonnull
    MFAuthModel model

    void click() {
        String sKey = "1234123412341234"
        GoogleAuthenticator gAuth = new GoogleAuthenticator()
        model.clickCount = gAuth.getTotpPassword(sKey)
    }
}