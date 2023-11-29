![](https://user-images.githubusercontent.com/7698209/33198075-ef8f2230-d123-11e7-85a3-4cb9b22f877d.png)
[![](https://jitpack.io/v/neo-turak/BaseRecyclerViewAdapterHelper.svg)](https://jitpack.io/#neo-turak/BaseRecyclerViewAdapterHelper)
# BRVAH

http://www.recyclerview.org/

Powerful and flexible RecyclerView Adapter,
Please feel free to use this. (Welcome to **Star** and **Fork**)
强大而灵活的RecyclerView Adapter（欢迎 **Star** 和 **Fork**）

# 说明：

这个是基于BaseRecyclerViewHelper的3.x版本做出的改动，我认为一个库的更新应该支持向下兼容的。  
1.全部类转化成Kotlin，项目结构移动到Kotlin目录下(避免新版本AS展示Kotlin+android)。  
2.重命名data对象到items. 因为data是在Kotlin内是预保留字段，不应该作为对象。  
3.持续更新文档，保证文档更全面（主库找不到很多类的使用说明）。  
4.对于内部方法的改进，补充低版本不兼容方法。  
5.提交到Jitpack.io,下载快。

# 如何使用

Step 1. Add the JitPack repository to your build file

````groovy
    dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
````
Step 2. Add the dependency
replace the Tag with the new version.
````groovy
	dependencies {
	        implementation 'com.github.neo-turak:BaseRecyclerViewAdapterHelper:Tag'
	}
````
# Document

- English Writing ...
- [3.0版本 中文](https://github.com/CymChad/BaseRecyclerViewAdapterHelper/blob/3.x/readme/0-BaseRecyclerViewAdapterHelper.md)

## Demo

[wiki](https://github.com/CymChad/BaseRecyclerViewAdapterHelper/wiki)

# proguard-rules.pro

> 此资源库自带混淆规则，并且会自动导入，正常情况下无需手动导入。

> The library comes with `proguard-rules.pro` rules and is automatically imported. Normally no
> manual import is required.
> You can also go here to
> view [proguard-rules](https://github.com/CymChad/BaseRecyclerViewAdapterHelper/blob/master/library/proguard-rules.pro)

# Thanks

[CymChad/BaseRecyclerViewAdapterHelper](https://jitpack.io/#CymChad/BaseRecyclerViewAdapterHelper)
[JoanZapata / base-adapter-helper](https://github.com/JoanZapata/base-adapter-helper)

# [License](https://github.com/CymChad/BaseRecyclerViewAdapterHelper/blob/master/LICENSE)
