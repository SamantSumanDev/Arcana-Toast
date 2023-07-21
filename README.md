# Arcana-Toast

<a href="https://opensource.org/licenses/Apache-2.0"><img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
<a href='https://developer.android.com'><img src='http://img.shields.io/badge/platform-android-green.svg'/></a>
<a href='https://jitpack.io/#SamantSumanDev/Arcana-Toast'><img src='https://jitpack.io/v/SamantSumanDev/Arcana-Toast.svg'/></a>


## Dependency Project Level

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:



```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

## Dependency App Level

Add dependency in your app module

```
	dependencies {
	        implementation 'com.github.SamantSumanDev:Arcana-Toast:{latest_version}' 
	}

```

## Four Toast Types 🖐🏼
```
        1. TOAST_SUCCESS
        2. TOAST_ERROR
        3. TOAST_WARNING
        4. TOAST_INFO
```

## Toast Duration ⌛️ 
```
        1. LONG_DURATION // 4 Seconds
        2. SHORT_DURATION // 2 Seconds
       
```

## Usage 

# Sample Code for - Arcana Toast 🌟 

### Success Toast
```
 ArcanaToast.createToast(
                this,
                "Well done!",
                "You successfully read this important message.",
                ArcanaToastStyle.SUCCESS,
                ArcanaToast.GRAVITY_TOP,
                ArcanaToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular)
            )
                
```

### Error Toast
```
 ArcanaToast.createToast(
                this,
                "Oh snap!",
                "Change a few things up and try submitting again.",
                ArcanaToastStyle.ERROR,
                ArcanaToast.GRAVITY_TOP,
                ArcanaToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular) )
```
### Warning Toast
```
ArcanaToast.createToast(
                this,
                "Warning!",
                "Sorry! There was a problem with your request.",
                ArcanaToastStyle.WARNING,
                ArcanaToast.GRAVITY_TOP,
                ArcanaToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular)
            )

        
```

### Help Toast
```
       ArcanaToast.createToast(
                this,
                "Hi there!",
                "Do you have a problem? Just use this contact form.",
                ArcanaToastStyle.HELP,
                ArcanaToast.GRAVITY_TOP,
                ArcanaToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular)
            )

```


