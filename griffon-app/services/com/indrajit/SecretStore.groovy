package com.indrajit
/**
 *
 * @author indrajit
 */

class SecretStore {
    private secrets = new HashMap<>()

    public SecretStore(){
        secrets.put('Sample','1234123412341234')
        secrets.put('Amazon','1234123412341233')
    }

    public secrtes(){
        return secrets
    }

    public count(){
        return secrets.size()
    }

}
