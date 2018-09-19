.PHONY: dev prd min show-figwheel-config npm-dev npm-prd clean clobber

dev: npm-dev
	clojure -A:figwheel

prd: npm-prd
	clojure --main "figwheel.main" --build-once "prd"
	cp target/public/cljs-out/prd-main.js dist/app.js
	cp -r resources/public/css dist

min: npm-prd
	clojure --main "figwheel.main" --build-once "min"
	cp target/public/cljs-out/min-main.js dist/app.js
	cp -r resources/public/css dist

show-figwheel-config:
	clojure -m figwheel.main -pc -b dev -r


npm-dev:
	make -C npm bundle-dev

npm-prd:
	make -C npm bundle-prd

clean:
	make -C npm clean
	rm -rf target out nashorn_code_cache .cljs_nashorn_repl
	rm -rf dist/*.js dist/css

clobber: clean
	make -C npm clobber
