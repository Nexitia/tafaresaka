

# JSOAGGER Web ui

Is a library containing UI components and common pages for Jsoagger based on React.js.

It integrates following view main technologies:
	- Bootstrap
	- React.js
	- React-Redux
	- React-bootstrap


# Maven how to

## Build

Will generates a library: jsoagger-webdev-${version}.jar, containing the source code of react.js components and views of JSoagger.

> mvn clean install

## Generate a new JSoagger React.js based UI

> mvn archetype generate 

## Override default files

Following files need to be overriden:
	tracker/src/index.js	 	-> need to be merged with default one in order to include custom reducers
	tracker/src/App.js 		-> replaces the default one in order to handle custom routes
	tracker/allRoutes.js 	-> replaces the default one
	
*default one means the one from original files

# Node.js How to

## Install dependencies

npm install


## Run

REACT_APP_BACKEND_HOST=http://localhost:8080/jsoagger/serv/core npm start

And browse : http://localhost:3000/#/demo



