# conceptual-ctrl
This repo is a template you can use to start helping you build your conceptual model

# setup

the following sections are to help you get boilerplate template setup for your projects conceptual model

## cloning

to help manage template dependencies this project utilizes git submodules. 

to clone project run the following 
```
git clone --recursive git@github.com:remote-ctrl/template-conceptual-ctrl.git
```

after cloning you can delete the following git dependencies to act as the boilerplate for your project

```
rm ./.git ./.gitmodules ./event-player/.git
```

to configure for your project you can create your repo as in the following example
```
git init
MY_CONCEPTUAL_REPO=my-conceptual-repo
git set remote origin $MY_CONCEPTUAL_REPO
git add **/*
git commit -m "my first conceptual contribution"
git push origin main
```

## prerequisites

### jvm

this template uses the following to install jvm prerequisites...
* sdkman (https://sdkman.io/) - follow link + instructions for your OS

```
JDK_VERSION=22.3.2.r11-grl
sdk install java $JDK_VERSION 
```

# validating

```
./gradlew :my-ctrl:jvmTest
```