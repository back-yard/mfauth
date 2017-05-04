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

    @MVCMember @Nonnull
    MFAuthView view

    GoogleAuthenticator gAuth = new GoogleAuthenticator()
    SecretStore store = new SecretStore()

    void updateToken(String key, String sKey) {
        model.authToken.put(key, gAuth.getTotpPassword(sKey))
        System.out.println(model.authToken.keySet())
        System.out.println(model.authToken.values())
    }

    def updateTokenTask = new TimerTask() {
        @Override
        void run() {
            for(String key : store.secrtes().keySet()) {
                updateToken(key, store.secrtes().get(key).toString())
            }
            model.changed = !model.changed
        }
    }

    def myTimer = new Timer().schedule(updateTokenTask, 10000, 10000)

}