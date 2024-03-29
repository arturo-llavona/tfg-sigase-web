/*
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.allavona.tfg.frontapp.business.webclient.api;

import com.allavona.tfg.frontapp.business.webclient.ApiCallback;
import com.allavona.tfg.frontapp.business.webclient.ApiClient;
import com.allavona.tfg.frontapp.business.webclient.ApiException;
import com.allavona.tfg.frontapp.business.webclient.ApiResponse;
import com.allavona.tfg.frontapp.business.webclient.Configuration;
import com.allavona.tfg.frontapp.business.webclient.Pair;

import com.google.gson.reflect.TypeToken;


import com.allavona.tfg.frontapp.business.webclient.model.Recurso;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResourcesApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ResourcesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ResourcesApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for listar
     * @param type  (optional)
     * @param onlyAvailable  (optional, default to true)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 401 </td><td> No se han encontrado resultados </td><td>  -  </td></tr>
        <tr><td> 200 </td><td> Consulta finalizada con éxito </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listarCall(Integer type, Boolean onlyAvailable, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/resources";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (type != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("type", type));
        }

        if (onlyAvailable != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("onlyAvailable", onlyAvailable));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listarValidateBeforeCall(Integer type, Boolean onlyAvailable, final ApiCallback _callback) throws ApiException {
        return listarCall(type, onlyAvailable, _callback);

    }

    /**
     * Lista todos los recursos
     * Este servicio lista todos los recursos del sistema
     * @param type  (optional)
     * @param onlyAvailable  (optional, default to true)
     * @return List&lt;Recurso&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 401 </td><td> No se han encontrado resultados </td><td>  -  </td></tr>
        <tr><td> 200 </td><td> Consulta finalizada con éxito </td><td>  -  </td></tr>
     </table>
     */
    public List<Recurso> listar(Integer type, Boolean onlyAvailable) throws ApiException {
        ApiResponse<List<Recurso>> localVarResp = listarWithHttpInfo(type, onlyAvailable);
        return localVarResp.getData();
    }

    /**
     * Lista todos los recursos
     * Este servicio lista todos los recursos del sistema
     * @param type  (optional)
     * @param onlyAvailable  (optional, default to true)
     * @return ApiResponse&lt;List&lt;Recurso&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 401 </td><td> No se han encontrado resultados </td><td>  -  </td></tr>
        <tr><td> 200 </td><td> Consulta finalizada con éxito </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<Recurso>> listarWithHttpInfo(Integer type, Boolean onlyAvailable) throws ApiException {
        okhttp3.Call localVarCall = listarValidateBeforeCall(type, onlyAvailable, null);
        Type localVarReturnType = new TypeToken<List<Recurso>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Lista todos los recursos (asynchronously)
     * Este servicio lista todos los recursos del sistema
     * @param type  (optional)
     * @param onlyAvailable  (optional, default to true)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 401 </td><td> No se han encontrado resultados </td><td>  -  </td></tr>
        <tr><td> 200 </td><td> Consulta finalizada con éxito </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listarAsync(Integer type, Boolean onlyAvailable, final ApiCallback<List<Recurso>> _callback) throws ApiException {

        okhttp3.Call localVarCall = listarValidateBeforeCall(type, onlyAvailable, _callback);
        Type localVarReturnType = new TypeToken<List<Recurso>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
