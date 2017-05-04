package com.indrajit

import griffon.core.artifact.GriffonView
import griffon.inject.MVCMember
import griffon.metadata.ArtifactProviderFor
import javax.swing.SwingConstants
import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonView)
class MFAuthView {
    @MVCMember @Nonnull
    FactoryBuilderSupport builder
    @MVCMember @Nonnull
    MFAuthModel model

    private store = new SecretStore()

    def c = { k, v -> model.authToken.size() }

    void initUI() {
        builder.with {
            application(size: [320, 100], id: 'mainWindow',
                title: application.configuration['application.title'],
                iconImage:   imageIcon('/griffon-icon-48x48.png').image,
                iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                             imageIcon('/griffon-icon-32x32.png').image,
                             imageIcon('/griffon-icon-16x16.png').image]) {
                gridLayout(rows: store.count(), cols: 2)
                for(String key : store.secrtes().keySet()) {
                    label(text: key, horizontalAlignment: SwingConstants.LEFT)
                    label(
                            id: key,
                            text: bind(model.changed, source: model.authToken, converter: c.curry(key)),
                            horizontalAlignment: SwingConstants.RIGHT
                    )
                }
            }
        }
    }
}