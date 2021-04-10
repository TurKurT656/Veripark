package com.turkurt656.buildsrc.modules

object DataModules {

    object Paths {
        const val data = "data"

        const val remote = "remote"
        const val local = "local"
        const val domain = "domain"
        const val domainImpl = "domainimpl"
    }

    val remote = module(Paths.data, Paths.remote)
    val local = module(Paths.data, Paths.local)
    val domain = module(Paths.data, Paths.domain)
    val domainImpl = module(Paths.data, Paths.domainImpl)

}