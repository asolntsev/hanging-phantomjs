# hanging-phantomjs
Showcase how to reproduce the "hanging PhantomJS" problem

### How to run project:

```bash
git clone https://github.com/asolntsev/hanging-phantomjs.git
cd hanging-phantomjs
./gradlew
```

### Environment:

This sample stably reproduces the hanging PhantomJS problem (at least) in the following environment:
* latest Mac OS 10.11.4
* latest PhantomJS 2.1.1
* latest PhantomJS driver 1.3.0
* latest selenium webdriver 2.53.0

### Motivation

There is a long-running problem with PhantomJS: it hangs when uploading a file.
Here is a list of some of registered tickets:

* [PhantomJS issue 10993](https://github.com/ariya/phantomjs/issues/10993): "Phantomjs / Ghostdriver crashes on sendKeys to file input element"  
* [PhantomJS driver issue 282](https://github.com/detro/ghostdriver/issues/282): "PhantomJS hanging on file upload (multiple)" 

I think this is a PhantomJS issue (not phantomjsdriver or webdriver), 
because thread dump shows that webdriver is just waiting for a PhantomJS response (indefinitely).

I hope this sample project will help PhantomJS authors to fix this issue.