// Run gangplank 
// Available parameters:
//     artifacts:    list    -- list of artifacts to be built  
//     cosaDir:      string  -- cosa working directory
//     image:        string  -- Name of the image to be used
//     specFile:     string  -- Name of the spec file
//     podMan:       boolean -- Run Gangangplank in pod mode
 
def call(params = [:]) {
    def cosaDir            = utils.getCosaDir(params)
    def artifacts          = params.get('artifacts', "");
    def image              = params.get('image', "");    
    def gangplankCmd       = "gangplank"

    // Define Gangplank Mode
    if (params['podMan']) {
        gangplankCmd += "--podman"
    } else {
        gangplankCmd += "pod"
    } 

    if (params['artifacts']) {
        gangplankCmd += "--artifact ${artifacts}"
    }
    else if (params['specFile']) {
        gangplankCmd += "--spec ${specFile}"
    }

    if (params['images']) {
        gangplankCmd += "--image ${image}"
    }

    //--srvDir
    //setWorkDirCtx

    shwrap(" ${gangplankCmd} --workDir ${cosaDir}")
}
    
