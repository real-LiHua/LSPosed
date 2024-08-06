project(external)

set(SOURCES lsplt/lsplt/src/main/jni/lsplt.cc lsplt/lsplt/src/main/jni/elf_util.cc)

add_library(lsplt STATIC ${SOURCES})
target_include_directories(lsplt PUBLIC lsplt/lsplt/src/main/jni/include)
target_include_directories(lsplt PRIVATE lsplt/lsplt/src/main/jni)


list(TRANSFORM LIBCXX_SOURCES PREPEND cxx/src/)

set(LIBCXX_EXPORT_FLAGS
        -DLIBCXX_BUILDING_LIBCXXABI
        -D_LIBCPP_NO_EXCEPTIONS
        -D_LIBCPP_NO_RTTI
        -D_LIBCPP_BUILDING_LIBRARY
        -D_LIBCPP_DISABLE_VISIBILITY_ANNOTATIONS
        -D_LIBCXXABI_NO_EXCEPTIONS
        -D_LIBCPP_HAS_NO_LOCALIZATION
        )
set(LIBCXX_FLAGS
        -fvisibility-global-new-delete-hidden
        -fvisibility=hidden
        -fvisibility-inlines-hidden
        )
set(LIBCXX_EXPORT_INCLUDES cxx/include)
set(LIBCXX_INCLUDES cxx/src)

set(LIBCXXABI_SOURCES
        abort_message.cpp
        cxa_aux_runtime.cpp
        cxa_default_handlers.cpp
        cxa_exception_storage.cpp
        cxa_guard.cpp
        cxa_handlers.cpp
        cxa_noexception.cpp
        cxa_thread_atexit.cpp
        cxa_vector.cpp
        cxa_virtual.cpp
        stdlib_exception.cpp
        stdlib_new_delete.cpp
        stdlib_stdexcept.cpp
        stdlib_typeinfo.cpp
        )
list(TRANSFORM LIBCXXABI_SOURCES PREPEND cxx/src/abi/)
set(LIBCXXABI_FLAGS
        -Wno-macro-redefined
        -Wno-unknown-attributes
        -DHAS_THREAD_LOCAL)
set(LIBCXXABI_INCLUDES cxx/include/abi)

add_library(cxx STATIC ${LIBCXX_SOURCES} ${LIBCXXABI_SOURCES})
target_compile_options(cxx PUBLIC ${LIBCXX_EXPORT_FLAGS})
target_compile_options(cxx PRIVATE ${LIBCXX_FLAGS} ${LIBCXXABI_FLAGS} -ffunction-sections -fdata-sections)
target_include_directories(cxx PUBLIC ${LIBCXX_EXPORT_INCLUDES})
target_include_directories(cxx PRIVATE ${LIBCXX_INCLUDES} ${LIBCXXABI_INCLUDES})

#find_package(cxx REQUIRED CONFIG)
link_libraries(cxx::cxx)

OPTION(LSPLANT_BUILD_SHARED OFF)
add_subdirectory(lsplant/lsplant/src/main/jni)
add_subdirectory(fmt)
target_compile_definitions(fmt-header-only INTERFACE FMT_STATIC_THOUSANDS_SEPARATOR=1 FMT_USE_FLOAT=0 FMT_USE_DOUBLE=0 FMT_USE_LONG_DOUBLE=0)
