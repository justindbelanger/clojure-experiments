all: build

CLJ_SOURCES=$(sh find src)

build: target/skinny-lein.jar target/lib target/system.properties
#build: my-skinny.jar lib

# classes: deps.edn $(CLJ_SOURCES)
# 	mkdir -p classes
# 	clojure -A:build -m rgm.build

target/skinny-lein.jar: pom.xml
	lein jar

target/lib: pom.xml
	mvn dependency:copy-dependencies -DoutputDirectory="$@"

target/system.properties:
	cp system.properties "$@"

# my-skinny.jar: classes pom.xml Manifest.txt
# 	# jar cfm "$@" Manifest.txt -C classes rgm/ # doesn't seem to do anything
# 	jar cf "$@" resources -C classes rgm/

clean:
	rm -rf classes target

clobber: clean
	rm -rf lib my-skinny.jar .cpcache

pom.xml: deps.edn
	clojure -Spom

.PHONY=build clean
