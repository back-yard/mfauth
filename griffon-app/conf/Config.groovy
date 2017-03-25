application {
    title = 'MF-auth'
    startupGroups = ['MFAuth']
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "MFAuth"
    'MFAuth' {
        model      = 'com.indrajit.MFAuthModel'
        view       = 'com.indrajit.MFAuthView'
        controller = 'com.indrajit.MFAuthController'
    }
}