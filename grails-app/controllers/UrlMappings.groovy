class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/flash")
        "/dashboard"(view:"/dashboard")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
