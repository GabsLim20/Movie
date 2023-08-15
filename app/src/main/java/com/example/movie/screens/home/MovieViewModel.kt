package com.example.movie.screens.home

class MovieViewModel {

}

//@HiltViewModel
//class QuestionViewModel @Inject constructor(private val  repository: QuestionRepository,application: Application):
//    AndroidViewModel(application){
//    val data: MutableState<DataOrException<ArrayList<Question>,
//            Boolean, Exception>> = mutableStateOf(
//        DataOrException(null, true, Exception("")))
//    init {
//        getAllQuestions()
//    }
//     fun getAllQuestions(){
//        viewModelScope.launch {
//            data.value.loading= true
//            data.value = repository.getAllQuestions()
//            if (data.value.data.toString().isNotEmpty()){
//                data.value.loading = false
//            }
//        }
//    }
//}