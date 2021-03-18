job:               
  strict: true     
recipe:            
  git_ref: testing-devel
  git_url: https://github.com/coreos/fedora-coreos-config   
stages:
- id: Builds the clouds
  build_artifacts:
  - aws
  - vmware
  concurrent_execution: true
