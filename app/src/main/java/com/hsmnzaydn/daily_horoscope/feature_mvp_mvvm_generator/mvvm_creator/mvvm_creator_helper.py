

def generateViewModelCode(packageName,viewmodelname):
    code = (f"package {packageName}.ui.{viewmodelname.lower()}\n\n"
            f"import androidx.hilt.Assisted\n"
            f"import androidx.lifecycle.SavedStateHandle\n"
            f"import dagger.hilt.android.lifecycle.HiltViewModel\n"
            f"import {packageName}.base.BaseViewModel\n"
            "import javax.inject.Inject\n"
            "@HiltViewModel\n"
            f"class {viewmodelname}VM @Inject constructor(@Assisted private val stateHandle: SavedStateHandle): \n"
            "BaseViewModel(){\n\n }")

    return code

def generateViewActivityCode(packageName,viewmodelname,viewType):
    code = (f"package {packageName}.ui.{viewmodelname.lower()}\n\n"
            "import android.os.Bundle\n"
            "import androidx.lifecycle.Observer\n"
            f"import {packageName}.ui.{viewmodelname.lower()}.{viewmodelname}ViewModel\n"
            f"import {packageName}.R\n"
            f"import {packageName}.base.BaseActivity\n"
            f"import {packageName}.base.BaseFragment\n"
            f"import {packageName}.base.BaseInterfaces\n"
            f"import {packageName}.databinding.{viewType}{viewmodelname}Binding\n\n"
            f"class {viewmodelname}{viewType} : BaseActivity<{viewType}{viewmodelname}Binding, {viewmodelname}ViewModel<BaseInterfaces>>()\n"
            "{\n\n"
            "override fun layoutRes(): Int = R.layout.layoutName\n"
            f"override fun model() = {viewmodelname}ViewModel::class.java\n"
            "}")

    return code

def generateFragmentViewCode(packageName,viewmodelName,viewType):

    code = (f"package {packageName}.ui.{viewmodelName.lower()}\n\n"
            f"import {packageName}.base.view.BaseFragment\n"
            "import dagger.hilt.android.AndroidEntryPoint\n"
            "import android.os.Bundle\n"
            "import android.view.LayoutInflater\n"
            "import android.view.ViewGroup\n"
            f"import javax.inject.Inject\n\n"
            "@AndroidEntryPoint\n"
            f"class {viewmodelName}Fragment : BaseFragment<{viewmodelName}VM,{viewType}{viewmodelName}Binding>()\n"
            "{\n"
            f"override fun getViewModelClass() = {viewmodelName}VM::class.java\n"
            f"override fun getViewBinding() = {viewType}{viewmodelName}Binding.inflate(layoutInflater)\n"
            "override fun initUI(inflater: LayoutInflater,\ncontainer: ViewGroup?,\nsavedInstanceState: Bundle?){\n"
            "}\n\n"
            "companion object{\n"
            f"fun newInstance() = {viewmodelName}{viewType}()\n"
            "}"
            "}\n")
    return code


def generateViewInjectorViewModelCode(viewmodelName,viewType):
    code = ("@ContributesAndroidInjector\n"
            f"abstract fun {viewmodelName.lower()}{viewType}Injector(): {viewmodelName}{viewType}\n")
    return code

def generateViewModelInjectorCode(viewmodelName,viewType):
    code = ("@Binds\n"
            "@IntoMap\n"
            f"@ViewModelKey({viewmodelName}VM::class)\n"
            f"internal abstract fun {viewmodelName.lower()}ViewModel(viewModel: {viewmodelName}ViewModel<BaseInterfaces>): ViewModel")
    return code        