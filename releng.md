# The planned changes

### olca-app-runtime
1. `platform.target` file should initially define *public* locations (i.e. web URLs instead of local file path) - it excludes excessive Ant task, that downloads 3rd party artifacts to file system and then publish that files in `target platform definition`.
2. Eclipse.org archive web-site is unreliable and slow, so we have to host their artifacts ourselves. For that I will use `bintray.com` (generic) at the moment, then we define where 3rd party artifacts should reside (see Infrastructure).

### olca-app-html
The source of this project are moving to `olca-app` plugin-in. There we run `node.js`-based build with [frontend-maven-plugin](https://github.com/eirslett/frontend-maven-plugin) and put results into the same `olca-app\html` folder.

### olca-app
- change `pom.xml` for Tycho build.
- move `openLCA.product` definition file to separate maven project, because it is diferent type of Tycho artifact
- it should be possible to build (package) product without installing `olca-modules` locally (into `~/.m2`) - for that reason releases or snaphsots should be hosted on some Maven repository - at the moment I am going to use `bintray.com`, later openLCA may register itself on Maven Central repository.

### olca-modules
change `pom.xml` files for Tycho build

### olca-updates
change `pom.xml` to be 

# Infrastructure
- snapshot maven repository - our own hosting (maybe [free one](https://docs.openshift.com/container-platform/3.5/dev_guide/app_tutorials/maven_tutorial.html)) - there are no public snapshot-enabled repos
- release maven repository - bintray.com or even Maven Central
- webserver to host P2 repositories for 3rd party and our IU (installable units)

# Continuous Delivery (optional)
- possible CI system - Travis-CI
- thinking over [the versioning schema based on git commits](https://blog.philipphauer.de/version-numbers-continuous-delivery-maven-docker/)
